package clearkode.entity.transactinInfo;

public class MerchantTransaction {
    private String referenceNo;
    private String merchantId;
    private String status;
    private String channel;
    private String customData;
    private String chainId;
    private String type;
    private String agentInfoId;
    private String operation;
    private String updated_at;
    private String created_at;
    private String id;
    private String fxTransactionId;
    private long acquirerTransactionId;
    private int code;
    private String message;
    private String transactionId;
    private Agent agent;


    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(String agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFxTransactionId() {
        return fxTransactionId;
    }

    public void setFxTransactionId(String fxTransactionId) {
        this.fxTransactionId = fxTransactionId;
    }

    public long getAcquirerTransactionId() {
        return acquirerTransactionId;
    }

    public void setAcquirerTransactionId(long acquirerTransactionId) {
        this.acquirerTransactionId = acquirerTransactionId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
