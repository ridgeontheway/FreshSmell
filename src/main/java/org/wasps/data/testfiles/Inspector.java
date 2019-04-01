package Main.concretes;

import Main.abstracts.IInspector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Inspector implements IInspector {
    // Returns true of a method's return type is primitive
    final Predicate<Method> methodIsPrimitive = object -> object.getReturnType().isPrimitive();
    // Returns true of a field is primitive
    final Predicate<Field> fieldIsPrimitive = object -> object.getType().isPrimitive();
    // Returns true of a method's parameter is primitive
    final Predicate<Parameter> parameterIsPrimitive = object -> object.getType().isPrimitive();
    // Returns true of a method's access type is private
    final Predicate<Method> methodIsPrivate = object -> Modifier.isPrivate(object.getModifiers());
    // Returns true of a method's access type is public
    final Predicate<Method> methodIsPublic = object -> Modifier.isPublic(object.getModifiers());

    /*
        For each public method:
            Get a list of the methods/fields/parameters of a given host for which the predicate is true
            Return the size of that list
        Using getDeclaredMethods() and getDeclaredFields() so I can also get the private ones
     */
    @Override
    public int getNumPrimitiveMethods(Class host) {
        List<Method> methods = queryMethod(host.getDeclaredMethods(), methodIsPrimitive);
        return methods.size();
    }

    @Override
    public int getNumPrimitiveFields(Class host) {
        List<Field> fields = queryField(host.getDeclaredFields(), fieldIsPrimitive);
        return fields.size();
    }

    @Override
    public int getNumPrimitiveParameters(Method host) {
        List<Parameter> parameters = queryParameter(host.getParameters(), parameterIsPrimitive);
        return parameters.size();
    }

    @Override
    public int getNumPrivateMethods(Class host) {
        List<Method> methods = queryMethod(host.getDeclaredMethods(), methodIsPrivate);
        return methods.size();
    }

    @Override
    public int getNumPublicMethods(Class host) {
        List<Method> methods = queryMethod(host.getDeclaredMethods(), methodIsPublic);
        return methods.size();
    }

    private List<Method> queryMethod(Method[] listToQuery, Predicate<Method> query) {
        List<Method> matches = new ArrayList<>();
        // Iterate through every method of the given class
        Arrays.asList(listToQuery).forEach(object -> {
            // If that method matches the given query, add it to the list of matches
            if (query.test(object))
                matches.add(object);
        });
        // This returns the list of matches, which is more modular than just returning the count at this stage
        // I do it this way on the other queries for the same reason
        return matches;
    }

    // This works the same way as queryMethod, but iterates through the fields instead
    private List<Field> queryField(Field[] listToQuery, Predicate<Field> query) {
        List<Field> matches = new ArrayList<>();
        Arrays.asList(listToQuery).forEach(object -> {
            if (query.test(object))
                matches.add(object);
        });
        return matches;
    }

    // This works the same way as queryMethod, but iterates through the paramters of a given method instead
    private List<Parameter> queryParameter(Parameter[] listToQuery, Predicate<Parameter> query) {
        List<Parameter> matches = new ArrayList<>();
        Arrays.asList(listToQuery).forEach(object -> {
            if (query.test(object))
                matches.add(object);
        });
        return matches;
    }

}
