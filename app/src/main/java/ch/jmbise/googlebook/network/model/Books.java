package ch.jmbise.googlebook.network.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Books {
    public static final class Book  implements Parcelable {
        public static final class VolumeInfo implements Parcelable {
            public static final class IndustryIdentifier implements Parcelable {
                private String type;
                private String identifier;

                protected IndustryIdentifier(Parcel in) {
                    type = in.readString();
                    identifier = in.readString();
                }

                public static final Creator<IndustryIdentifier> CREATOR = new Creator<IndustryIdentifier>() {
                    @Override
                    public IndustryIdentifier createFromParcel(Parcel in) {
                        return new IndustryIdentifier(in);
                    }

                    @Override
                    public IndustryIdentifier[] newArray(int size) {
                        return new IndustryIdentifier[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(type);
                    dest.writeString(identifier);
                }

                public String getType() {
                    return type;
                }

                public String getIdentifier() {
                    return identifier;
                }
            }
            public static final class ReadingMode implements Parcelable {
                private Boolean text;
                private Boolean image;

                protected ReadingMode(Parcel in) {
                    text = in.readByte() != 0;
                    image = in.readByte() != 0;
                }

                public static final Creator<ReadingMode> CREATOR = new Creator<ReadingMode>() {
                    @Override
                    public ReadingMode createFromParcel(Parcel in) {
                        return new ReadingMode(in);
                    }

                    @Override
                    public ReadingMode[] newArray(int size) {
                        return new ReadingMode[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeByte((byte) (text ? 1 : 0));
                    dest.writeByte((byte) (image ? 1 : 0));
                }

                public Boolean getText() {
                    return text;
                }

                public Boolean getImage() {
                    return image;
                }
            }
            public static final class ImageLink implements Parcelable{
                private String smallThumbnail;
                private String thumbnail;

                protected ImageLink(Parcel in) {
                    smallThumbnail = in.readString();
                    thumbnail = in.readString();
                }

                public static final Creator<ImageLink> CREATOR = new Creator<ImageLink>() {
                    @Override
                    public ImageLink createFromParcel(Parcel in) {
                        return new ImageLink(in);
                    }

                    @Override
                    public ImageLink[] newArray(int size) {
                        return new ImageLink[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(smallThumbnail);
                    dest.writeString(thumbnail);
                }

                public String getSmallThumbnail() {
                    return smallThumbnail;
                }

                public String getThumbnail() {
                    return thumbnail;
                }
            }

            private String title;
            private String subtitle;
            private String[] authors;
            private String publisher;
            private String publishedDate;
            private IndustryIdentifier[] industryIdentifiers;
            private ReadingMode readingModes;
            private Integer pageCount;
            private String printType;
            private Double averageRating;
            private Integer ratingsCount;
            private String maturityRating;
            private Boolean allowAnonLogging;
            private String contentVersion;
            private ImageLink imageLinks;
            private String language;
            private String previewLink;
            private String infoLink;
            private String canonicalVolumeLink;

            protected VolumeInfo(Parcel in) {
                title = in.readString();
                subtitle = in.readString();
                authors = in.createStringArray();
                publisher = in.readString();
                publishedDate = in.readString();
                industryIdentifiers = in.createTypedArray(IndustryIdentifier.CREATOR);
                readingModes = in.readParcelable(ReadingMode.class.getClassLoader());
                pageCount = in.readInt();
                printType = in.readString();
                averageRating = in.readDouble();
                ratingsCount = in.readInt();
                maturityRating = in.readString();
                allowAnonLogging = in.readByte() != 0;
                contentVersion = in.readString();
                imageLinks = in.readParcelable(ImageLink.class.getClassLoader());
                language = in.readString();
                previewLink = in.readString();
                infoLink = in.readString();
                canonicalVolumeLink = in.readString();
            }

            public static final Creator<VolumeInfo> CREATOR = new Creator<VolumeInfo>() {
                @Override
                public VolumeInfo createFromParcel(Parcel in) {
                    return new VolumeInfo(in);
                }

                @Override
                public VolumeInfo[] newArray(int size) {
                    return new VolumeInfo[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(title);
                dest.writeString(subtitle);
                dest.writeStringArray(authors);
                dest.writeString(publisher);
                dest.writeString(publishedDate);
                dest.writeTypedArray(industryIdentifiers, flags);
                dest.writeParcelable(readingModes, flags);
                dest.writeInt(pageCount);
                dest.writeString(printType);
                dest.writeDouble(averageRating);
                dest.writeInt(ratingsCount);
                dest.writeString(maturityRating);
                dest.writeByte((byte) (allowAnonLogging ? 1 : 0));
                dest.writeString(contentVersion);
                dest.writeParcelable(imageLinks, flags);
                dest.writeString(language);
                dest.writeString(previewLink);
                dest.writeString(infoLink);
                dest.writeString(canonicalVolumeLink);
            }

            public String getTitle() {
                return title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public String[] getAuthors() {
                return authors;
            }

            public String getPublisher() {
                return publisher;
            }

            public String getPublishedDate() {
                return publishedDate;
            }

            public IndustryIdentifier[] getIndustryIdentifiers() {
                return industryIdentifiers;
            }

            public ReadingMode getReadingModes() {
                return readingModes;
            }

            public Integer getPageCount() {
                return pageCount;
            }

            public String getPrintType() {
                return printType;
            }

            public Double getAverageRating() {
                return averageRating;
            }

            public Integer getRatingsCount() {
                return ratingsCount;
            }

            public String getMaturityRating() {
                return maturityRating;
            }

            public Boolean getAllowAnonLogging() {
                return allowAnonLogging;
            }

            public String getContentVersion() {
                return contentVersion;
            }

            public ImageLink getImageLinks() {
                return imageLinks;
            }

            public String getLanguage() {
                return language;
            }

            public String getPreviewLink() {
                return previewLink;
            }

            public String getInfoLink() {
                return infoLink;
            }

            public String getCanonicalVolumeLink() {
                return canonicalVolumeLink;
            }
        }
        public static final class SaleInfo implements Parcelable {
            private String country;
            private String saleability;
            private Boolean isEbook;

            protected SaleInfo(Parcel in) {
                country = in.readString();
                saleability = in.readString();
                isEbook = in.readByte() != 0;
            }

            public static final Creator<SaleInfo> CREATOR = new Creator<SaleInfo>() {
                @Override
                public SaleInfo createFromParcel(Parcel in) {
                    return new SaleInfo(in);
                }

                @Override
                public SaleInfo[] newArray(int size) {
                    return new SaleInfo[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(country);
                dest.writeString(saleability);
                dest.writeByte((byte) (isEbook ? 1 : 0));
            }

            public String getCountry() {
                return country;
            }

            public String getSaleability() {
                return saleability;
            }

            public Boolean getEbook() {
                return isEbook;
            }
        }

        public static final class AccessInfo implements Parcelable {
            public static final class Epub implements Parcelable{
                Boolean isAvailable;

                protected Epub(Parcel in) {
                    isAvailable = in.readByte() != 0;
                }

                public static final Creator<Epub> CREATOR = new Creator<Epub>() {
                    @Override
                    public Epub createFromParcel(Parcel in) {
                        return new Epub(in);
                    }

                    @Override
                    public Epub[] newArray(int size) {
                        return new Epub[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeByte((byte) (isAvailable ? 1 : 0));
                }

                public Boolean getAvailable() {
                    return isAvailable;
                }
            }
            public static final class PDF implements Parcelable {
                Boolean isAvailable;

                protected PDF(Parcel in) {
                    isAvailable = in.readByte() != 0;
                }

                public static final Parcelable.Creator<PDF> CREATOR = new Parcelable.Creator<PDF>() {
                    @Override
                    public PDF createFromParcel(Parcel in) {
                        return new PDF(in);
                    }

                    @Override
                    public PDF[] newArray(int size) {
                        return new PDF[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeByte((byte) (isAvailable ? 1 : 0));
                }

                public Boolean getAvailable() {
                    return isAvailable;
                }
            }

            private String country;
            private String viewability;
            private Boolean embeddable;
            private Boolean publicDomain;
            private String textToSpeechPermission;
            private Epub epub;
            private PDF pdf;
            private String webReaderLink;
            private String accessViewStatus;
            private Boolean quoteSharingAllowed;

            protected AccessInfo(Parcel in) {
                country = in.readString();
                viewability = in.readString();
                embeddable = in.readByte() != 0;
                publicDomain = in.readByte() != 0;
                textToSpeechPermission = in.readString();
                epub = in.readParcelable(Epub.class.getClassLoader());
                pdf = in.readParcelable(PDF.class.getClassLoader());
                webReaderLink = in.readString();
                accessViewStatus = in.readString();
                quoteSharingAllowed = in.readByte() != 0;
            }

            public static final Creator<AccessInfo> CREATOR = new Creator<AccessInfo>() {
                @Override
                public AccessInfo createFromParcel(Parcel in) {
                    return new AccessInfo(in);
                }

                @Override
                public AccessInfo[] newArray(int size) {
                    return new AccessInfo[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(country);
                dest.writeString(viewability);
                dest.writeByte((byte) (embeddable ? 1 : 0));
                dest.writeByte((byte) (publicDomain ? 1 : 0));
                dest.writeString(textToSpeechPermission);
                dest.writeParcelable(epub, flags);
                dest.writeParcelable(pdf, flags);
                dest.writeString(webReaderLink);
                dest.writeString(accessViewStatus);
                dest.writeByte((byte) (quoteSharingAllowed ? 1 : 0));
            }

            public String getCountry() {
                return country;
            }

            public String getViewability() {
                return viewability;
            }

            public Boolean getEmbeddable() {
                return embeddable;
            }

            public Boolean getPublicDomain() {
                return publicDomain;
            }

            public String getTextToSpeechPermission() {
                return textToSpeechPermission;
            }

            public Epub getEpub() {
                return epub;
            }

            public PDF getPdf() {
                return pdf;
            }

            public String getWebReaderLink() {
                return webReaderLink;
            }

            public String getAccessViewStatus() {
                return accessViewStatus;
            }

            public Boolean getQuoteSharingAllowed() {
                return quoteSharingAllowed;
            }
        }

        protected Book(Parcel in) {
            id = in.readString();
            etag = in.readString();
            selfLink = in.readString();
            volumeInfo = in.readParcelable(VolumeInfo.class.getClassLoader());
            saleInfo = in.readParcelable(SaleInfo.class.getClassLoader());
            accessInfo = in.readParcelable(AccessInfo.class.getClassLoader());
        }

        public static final Creator<Book> CREATOR = new Creator<Book>() {
            @Override
            public Book createFromParcel(Parcel in) {
                return new Book(in);
            }

            @Override
            public Book[] newArray(int size) {
                return new Book[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(etag);
            dest.writeString(selfLink);
            dest.writeParcelable(volumeInfo, flags);
            dest.writeParcelable(saleInfo, flags);
            dest.writeParcelable(accessInfo, flags);
        }

        private String id;
        private String etag;
        private String selfLink;
        private VolumeInfo volumeInfo;
        private SaleInfo saleInfo;
        private AccessInfo accessInfo;

        public String getId() {
            return id;
        }

        public String getEtag() {
            return etag;
        }

        public String getSelfLink() {
            return selfLink;
        }

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public SaleInfo getSaleInfo() {
            return saleInfo;
        }

        public AccessInfo getAccessInfo() {
            return accessInfo;
        }
    }

    private Integer totalItems;
    private Book[] items;

    public Book[] getItems() {
        return items;
    }

    public Integer getTotalItems() {
        return totalItems;
    }
}
