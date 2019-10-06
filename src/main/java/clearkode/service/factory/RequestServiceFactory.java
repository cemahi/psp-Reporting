package clearkode.service.factory;

import clearkode.service.RequestService;
import clearkode.service.TransactionService;

public class RequestServiceFactory {
    private static RequestServiceFactory requestServiceFactory;

    public static RequestServiceFactory getInstance() {
        if (getRequestServiceFactory() == null) {
            return new RequestServiceFactory();
        } else {
            return getRequestServiceFactory();
        }
    }

    public RequestService getRequestFactory(String factory, TransactionService transactionService) {
        if (factory.equalsIgnoreCase("login")) {
            return new LoginRequest(transactionService);
        } else if (factory.equalsIgnoreCase("clientInfo")) {
            return new ClientInfoRequest(transactionService);
        } else if (factory.equalsIgnoreCase("txInfo")) {
            return new TransactionInfoRequest(transactionService);
        } else if (factory.equalsIgnoreCase("txQuery")) {
            return new TransactionQueryRequest(transactionService);
        } else if (factory.equalsIgnoreCase("txReport")) {
            return new TransactionReportRequest(transactionService);
        }
        return null;
    }

    public static RequestServiceFactory getRequestServiceFactory() {
        return requestServiceFactory;
    }

    public static void setRequestServiceFactory(RequestServiceFactory requestServiceFactory) {
        RequestServiceFactory.requestServiceFactory = requestServiceFactory;
    }
}
