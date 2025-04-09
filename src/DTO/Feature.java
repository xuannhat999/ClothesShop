package DTO;

public class Feature {
    private int featureId;
    private String featureName;

    public Feature(){}
    public Feature(int featureId, String featureName) {
        this.featureId = featureId;
        this.featureName = featureName;
    }

    public Feature(Feature d) {
        this.featureId = d.featureId;
        this.featureName = d.featureName;
    }

    public int getFeatureId() { return featureId; }
    public void setFeatureId(int featureId) { this.featureId = featureId; }
    public String getFeatureName() { return featureName; }
    public void setFeatureName(String featureName) { this.featureName = featureName; }
}
