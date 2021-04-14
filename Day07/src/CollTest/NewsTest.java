package CollTest;

import java.util.ArrayList;
import java.util.ListIterator;

/*
1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；（10分）

2)只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
新闻二：春节临近北京“卖房热”

3)将新闻对象添加到ArrayList集合中，并且使用ListIterator倒序遍历；

4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前14个，然后在后边加“…”

5)在控制台打印遍历出经过处理的新闻标题；
 */
public class NewsTest {
    public static void main(String[] args) {
        news news1=new news("新闻一：中国多地遭雾霾笼罩空气质量再成热议话题");
        news news2=new news("新闻二：春节临近北京“卖房热”");

        ArrayList arrayList=new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);

        //逆序遍历
        ListIterator listIterator= arrayList.listIterator();
        while( listIterator.hasNext()){
            listIterator.next();

        }

        while( listIterator.hasPrevious()){
            Object obj=listIterator.previous();
            news o=(news) obj;
            if( o.getHeadLine().length() > 15){
                o.setHeadLine(o.getHeadLine().substring(0,15)+ "...");
            }
            System.out.println(o.getHeadLine());

        }


    }

}

class news{
    private String headLine;
    private String content ;

    public news() {
    }

    public news(String headLine) {
        this.headLine = headLine;
    }

    public news(String headLine, String content) {
        this.headLine = headLine;
        this.content = content;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "news{" +
                "headLine='" + headLine + '\'';
    }
}