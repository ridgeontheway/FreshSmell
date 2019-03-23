package org.wasps.service.abstracts;

/*
    ISmeller is the interface for controllers to access our smelling service layer
    It provides a one-for-all way to access any smeller service
 */
public interface ISmeller {
    ISmellerService smellerService();
}
