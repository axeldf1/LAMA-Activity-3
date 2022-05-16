package lama.activity3.Market.Exceptions;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException(Long id) {
        super("Could not find offer " + id);
    }
}
