package koval.video.web.gsmarena.service.enums;

public enum BrandOption {
    ACER("Acer"),
    APPLE("Apple"),
    BENEFON("Benefon"),
    GOOGLE("Google"),

    SAMSUNG("Samsung"),
    HONOR("Honor");

    final String brandOption;

    BrandOption(String brandOption) {
        this.brandOption=brandOption;
    }

    public String getBrandOption()
    {
        return brandOption;
    }
}
