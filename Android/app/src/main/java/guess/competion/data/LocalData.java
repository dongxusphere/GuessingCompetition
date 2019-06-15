package guess.competion.data;

/**
 * @ClassName: LocalData
 * @Description:
 * @Author: dongxu.zhao
 * @Date: 2019-06-15 16:32
 */
public class LocalData {
    private static final LocalData ourInstance = new LocalData();

    public static LocalData getInstance() {
        return ourInstance;
    }

    private LocalData() {
    }

    private   int totalcount = 0;

    public  void addTotalcount(int count){
        totalcount+=count;
    }
    public void delTotalCount(int count ){
        totalcount-=count;
        if(totalcount<=0){
            totalcount=0;
        }
    }

    public  int getTotalcount(){
        return totalcount;
    }
}
