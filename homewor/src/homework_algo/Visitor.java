package homework_algo;

import homework_algo.coffee_entity.Coffee;

    public class Visitor {
        private String visitorName;
        private Coffee taste;
        private int drinkingTime;
        private String eyesColor;
        private int age;

        private Visitor(Builder builder) {
            visitorName = builder.visitorName;
            taste = builder.taste;
            drinkingTime = builder.drinkingTime;
            eyesColor = builder.eyesColor;
            age = builder.age;
        }

        public static Builder newBuilder() {
            return new Builder();
        }


        public static final class Builder {
            private String visitorName;
            private Coffee taste;
            private int drinkingTime;
            private String eyesColor;
            private int age;

            private Builder() {
            }

            public Builder visitorName(String val) {
                visitorName = val;
                return this;
            }

            public Builder taste(Coffee val) {
                taste = val;
                return this;
            }

            public Builder drinkingTime(int val) {
                drinkingTime = val;
                return this;
            }

            public Builder eyesColor(String val) {
                eyesColor = val;
                return this;
            }

            public Builder age(int val) {
                age = val;
                return this;
            }

            public Visitor build() {
                return new Visitor(this);
            }
        }
    }