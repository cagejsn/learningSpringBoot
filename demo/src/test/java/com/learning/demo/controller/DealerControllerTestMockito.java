package com.learning.demo.controller;

import com.learning.demo.exception.UnableToPlaceBetException;
import com.learning.demo.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DealerController.class})
@SpyBean(GameService.class)
public class DealerControllerTestMockito {

    @Autowired
    GameService bettingService;

    @Autowired
    DealerController dealerController;

    @Test
    void testController() throws UnableToPlaceBetException {

        Mockito.doThrow(new RuntimeException("Hello")).when(bettingService).placeBet(any());

        Exception e = Assertions.assertThrows(
                RuntimeException.class,
                () -> dealerController.deal()
        );

        Assertions.assertEquals(e.getMessage(), "Hello");

    }


}
