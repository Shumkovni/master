import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SiteAdress extends RecursiveTask<HashSet<String>> {

    private HashSet<String> listSites;

    public SiteAdress(HashSet<String> listSites){
        this.listSites = listSites;
    }

    @Override
    protected HashSet<String> compute() {
        HashSet<SiteAdress> taskList = new HashSet<>();
        try {
            for (String str1 : listSites) {
                SiteAdress task = new SiteAdress(Parser.parseHTML(str1));
                task.fork();
                taskList.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (SiteAdress task : taskList){
//                listSites.addAll(task.join());
//        }
        return listSites;
    }
}
