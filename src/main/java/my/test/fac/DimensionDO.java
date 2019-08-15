package my.test.fac;

public class DimensionDO {

    /**
     * SMY银行编号
     */
    private String bankCode;
    
    /**
     * 支付渠道编号。为空说明还没有选择路由
     */
    private String channelId;
    
    /**
     * 订单类型。1. 用户还款，2. 消费
     */
    private String transType;
    
    /**
     * 客户编号。非SMY可以为空
     */
    private String custNo;
    
    /**
     * 商户编号
     */
    private String merchantId;

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
    
}
