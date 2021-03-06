package spring.service;

import spring.model.ConcertSession;
import spring.model.ShoppingCart;
import spring.model.User;

public interface ShoppingCartService {
    void addSession(ConcertSession concertSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
