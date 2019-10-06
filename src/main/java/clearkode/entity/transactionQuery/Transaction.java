package clearkode.entity.transactionQuery;

import clearkode.entity.transactinInfo.MerchantTransaction;

public class Transaction {
    private MerchantTransaction merchant;

    public MerchantTransaction getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantTransaction merchant) {
        this.merchant = merchant;
    }
}
