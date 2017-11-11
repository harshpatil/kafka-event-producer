package kafka;

public class ViewEvent {

    private String ipAddress;
    private String userId;
    private String productId;
    private String productCategory;

    public ViewEvent(String ipAddress, String userId, String productId, String productCategory) {
        this.ipAddress = ipAddress;
        this.userId = userId;
        this.productId = productId;
        this.productCategory = productCategory;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
