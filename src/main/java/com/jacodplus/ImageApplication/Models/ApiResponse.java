package com.jacodplus.ImageApplication.Models;

import java.util.List;

public class ApiResponse {
    private DataWrapper data;

    public DataWrapper getData() { return data; }
    public void setData(DataWrapper data) { this.data = data; }

    public static class DataWrapper {
        private BrandGrid brandGridByPath;

        public BrandGrid getBrandGridByPath() { return brandGridByPath; }
        public void setBrandGridByPath(BrandGrid brandGridByPath) { this.brandGridByPath = brandGridByPath; }
    }

    public static class BrandGrid {
        private Item item;

        public Item getItem() { return item; }
        public void setItem(Item item) { this.item = item; }
    }

    public static class Item {
        private List<Brand> brands;

        public List<Brand> getBrands() { return brands; }
        public void setBrands(List<Brand> brands) { this.brands = brands; }
    }

    public static class Brand {
        private String brandId;
        private BrandImage brandImage;
        private String accessibilityText;
        private List<Card> supportedCards;

        public String getBrandId() { return brandId; }
        public void setBrandId(String brandId) { this.brandId = brandId; }

        public BrandImage getBrandImage() { return brandImage; }
        public void setBrandImage(BrandImage brandImage) { this.brandImage = brandImage; }

        public String getAccessibilityText() { return accessibilityText; }
        public void setAccessibilityText(String accessibilityText) { this.accessibilityText = accessibilityText; }

        public List<Card> getSupportedCards() { return supportedCards; }
        public void setSupportedCards(List<Card> supportedCards) { this.supportedCards = supportedCards; }
    }

    public static class BrandImage {
        private String _path;

        public String get_path() { return _path; }
        public void set_path(String _path) { this._path = _path; }
    }

    public static class Card {
        private String cardId;
        private String cardName;
        private CardArt cardArt;
        private String signInUrl;
        private String accessibilityText;

        public String getCardId() { return cardId; }
        public void setCardId(String cardId) { this.cardId = cardId; }

        public String getCardName() { return cardName; }
        public void setCardName(String cardName) { this.cardName = cardName; }

        public CardArt getCardArt() { return cardArt; }
        public void setCardArt(CardArt cardArt) { this.cardArt = cardArt; }

        public String getSignInUrl() { return signInUrl; }
        public void setSignInUrl(String signInUrl) { this.signInUrl = signInUrl; }

        public String getAccessibilityText() { return accessibilityText; }
        public void setAccessibilityText(String accessibilityText) { this.accessibilityText = accessibilityText; }
    }

    public static class CardArt {
        private String _path;

        public String get_path() { return _path; }
        public void set_path(String _path) { this._path = _path; }
    }
}

