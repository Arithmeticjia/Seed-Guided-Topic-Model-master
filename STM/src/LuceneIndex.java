package STM.src;

//import Util.LuceneWriter;

import STM.src.Util.LuceneWriter;

/**
 * Created by XJ on 2016/8/5.
 */
public class LuceneIndex implements Decorator {

    private SModel model;


    public LuceneIndex(SModel model) {
        this.model = model;
    }

    private void luceneIndex(){
        System.out.println(model.luceneIndexPath);
        System.out.println(model.catalogPath);
        LuceneWriter.writeIndex(model.luceneIndexPath,model.testSetPath,model.cateNum,model.catalogPath,true);
        LuceneWriter.writeIndex_append(model.luceneIndexPath, model.trainSetPath, model.cateNum, model.catalogPath, false);
        System.out.println(model.luceneIndexPath);
        System.out.println(model.catalogPath);
    }

    @Override
    public SModel decorateSModel() {
        luceneIndex();
        return model;
    }
}
