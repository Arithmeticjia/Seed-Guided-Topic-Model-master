package STM.src;

/**
 * Created by XJ on 2016/3/10.
 */
public class stm {
    public static void main(String[] args) {

        SModel model = new SModel();
       
        //parameters need to be specified
        // the number of category
        model.cateNum = 2;
        // test set path
        model.testSetPath = "/Users/Arithmetic/SGTM/20news-bydate/20news-bydate-test";
        model.trainSetPath = "/Users/Arithmetic/SGTM/20news-bydate/20news-bydate-train";
        // catalog file path
        model.catalogPath = "./catalog/politics-religion";
        //seed word  file path
        model.seedwordPath = "./seedword/SD/politics-religion";

        //parameters can use default value
        model.luceneIndexPath = "./luceneIndex";
//        model.cateNum = 2; // the number of category
//        model.testSetPath = "D:\\dataset\\20news_bydate_reform\\test"; // test set path
//        model.trainSetPath = "D:\\dataset\\20news_bydate_reform\\train";
//        model.catalogPath = ".\\catalog\\politics-religion"; // catalog file path
//        model.seedwordPath = ".\\seedword\\SD\\politics-religion"; //seed word  file path
//
//        //parameters can use default value
//        model.luceneIndexPath = ".\\luceneIndex";
        //topic number
        model.topicNum = 3 * model.cateNum;
        model.alpha0 = (float) 50 / model.topicNum;
        model.alpha1 = 100;
        model.beta0 = (float) 0.01;
        model.beta1 = (float) 0.01;
        model.rho = (float) 0.8;
        model.inter = 50; // iterations
        model.report = 1; // 1:macro F1 , 0:accuracy
        model.maxDocLen = 40000; // max document length

        //index the corpus
        new LuceneIndex(model).decorateSModel();

        // initialize the variates
        new Initialize(model).decorateSModel();

        //load the documents
        new LoadDocs(model).decorateSModel();

        //calculate the relevant weight between seed word and category
        new Co_occurrence(model).decorateSModel();

        //predict the category label of documents
        new Predict(model).decorateSModel();

    }
}
