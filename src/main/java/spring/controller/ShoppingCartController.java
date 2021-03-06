package spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.response.ShoppingCartResponseDto;
import spring.model.ConcertSession;
import spring.model.User;
import spring.service.ConcertSessionService;
import spring.service.ShoppingCartService;
import spring.service.UserService;
import spring.service.mapper.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final ConcertSessionService concertSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  ConcertSessionService concertSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.concertSessionService = concertSessionService;
    }

    @PostMapping("/movie-sessions")
    public void addToCart(Authentication auth, @RequestParam Long movieSessionId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        ConcertSession concertSession = concertSessionService.get(movieSessionId);
        shoppingCartService.addSession(concertSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
