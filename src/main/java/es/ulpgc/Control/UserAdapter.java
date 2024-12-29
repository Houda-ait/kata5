package es.ulpgc.Control;

import es.ulpgc.Model.User;

public interface UserAdapter<T> {

    User adapt(T t);
}
