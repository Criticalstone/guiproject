package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.util.List;

/**
 * Created by kritt on 2015-03-04.
 */
public class CategoryInterpreter {
    private static IMatDataHandler imat = IMatDataHandler.getInstance();
    public static enum Category{
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

    public static List<Product> getProductFromCateg(Category categ){
        List<Product> result;
        switch (categ){
            case BEEFMEAT:
                    result = imat.findProducts("Grytbitar");
                    result.add(imat.getProduct(72));
                    result.add(imat.getProduct(76));
                    break;
            case CHICKEN: result = imat.findProducts("Kyckling"); break;
            case SALT: result = imat.findProducts("Salt"); break;
            case SUGAR: result = imat.findProducts("Socker"); break;
            case FLOUR: result = imat.findProducts("Mjöl");
                result.remove(0);
                result.remove(2);
                break;
            case POTATO: result = imat.findProducts("Potatis"); break;
            case RICE: result = imat.findProducts("Ris"); break;
            default: result = imat.getProducts(customCategToCateg(categ));
        }

        return result;
    }

    public static ProductCategory customCategToCateg(Category categ){
        return ProductCategory.valueOf(categ.toString());
    }

    public static Category categoryValueOf(String stringCateg){
        Category categ = Category.POD;
        while(!stringCateg.equals(categ.next().toString())){
            categ = categ.next();
        }

        return categ.next();
    }
}
