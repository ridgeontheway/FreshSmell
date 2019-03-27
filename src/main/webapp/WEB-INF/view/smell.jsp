<!DOCTYPE html>
<html data-ng-app>
<head>
    <title>Hello Smells Angular</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script src="smells.js"></script>
</head>

<body>
<!-- 'Events' is bound to function in events.js -->
<div data-ng-controller="Smell">
    I have {{smells.length}} smells!

    <ul class="smells-container">
        <li data-ng-repeat="smell in smells">
            {{smell.name}}
        </li>
    </ul>
</div>
</body>
</html>