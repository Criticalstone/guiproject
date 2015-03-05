package guiProject;

/**
 * Created by kritt on 2015-03-05.
 */
public enum Category {
    POD, BREAD, BERRY, CITRUS_FRUIT, HOT_DRINKS, COLD_DRINKS, EXOTIC_FRUIT,
    FISH, VEGETABLE_FRUIT, CABBAGE, BEEFMEAT, CHICKEN, DAIRIES, MELONS,
    SALT, SUGAR, FLOUR, NUTS_AND_SEEDS, PASTA, POTATO, RICE, ROOT_VEGETABLE, FRUIT,
    SWEET,
    HERB{
        @Override
        public Category next() {
            return null;
        }
    };


    public Category next() {
        return values()[ordinal() + 1];
    }
}
