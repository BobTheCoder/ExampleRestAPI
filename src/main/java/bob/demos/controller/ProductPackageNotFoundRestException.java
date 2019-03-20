package bob.demos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductPackageNotFoundRestException extends Exception {
    private static final long serialVersionUID = 1L;

    public ProductPackageNotFoundRestException(String message) {
        super(message);
    }
}
