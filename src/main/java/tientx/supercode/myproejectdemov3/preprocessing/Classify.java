/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientx.supercode.myproejectdemov3.preprocessing;

import java.util.ArrayList;
import tientx.supercode.myproejectdemov3.config.Variable;
import tientx.supercode.myproejectdemov3.dao.OriginEntryDao;
import tientx.supercode.myproejectdemov3.dao.OriginEntryDaoImpl;
import tientx.supercode.myproejectdemov3.model.OriginEntry;
import tientx.supercode.myproejectdemov3.service.CategoryTrainingService;
import tientx.supercode.myproejectdemov3.service.CategoryTrainingServiceImpl;
import tientx.supercode.myproejectdemov3.service.SentimentTrainingService;
import tientx.supercode.myproejectdemov3.service.SentimentTrainingServiceImpl;
import tientx.supercode.myproejectdemov3.service.UserService;
import tientx.supercode.myproejectdemov3.service.UserServiceImpl;

/**
 *
 * @author zOzDarKzOz
 */
public class Classify
{

    private static CategoryTrainingService ct = new CategoryTrainingServiceImpl();
    private static OriginEntryDao oed = new OriginEntryDaoImpl();
    private static UserService us = new UserServiceImpl();
    private static SentimentTrainingService st = new SentimentTrainingServiceImpl();

    private static void categoryTrain(String path)
    {
        if (st.train(path)) {
            System.out.println("Trained");
        } else {
            System.out.println("Trainng fail!");
        }
    }

    private static void sentimentTrain(String path)
    {
        if (st.train(path)) {
            System.out.println("Trained");
        } else {
            System.out.println("Trainng fail!");
        }
    }

    private static void categoryClassify()
    {
        try {
            ArrayList<OriginEntry> listContent = oed.getAll();
            int l = listContent.size();
            int k = 0;
            int size = 0;
            while (k < l) {
                ArrayList<OriginEntry> list = new ArrayList<>();
                if (k + 100 < l) {
                    size = k + 100;
                } else {
                    size = l;
                }
                for (int i = k; i < size; i++) {
                    list.add(listContent.get(i));
                }
                int j = 1;
                for (OriginEntry content : list) {
                    String text = content.getsContent();
                    String cat = ct.classify(text);
                    System.out.println(j + "--------Category: " + cat);
                    content.setsCategory(cat);
                    j++;
                }
                boolean isOK = us.editListOriginEntryUseBatch(listContent);
                if (isOK) {
                    System.out.println("Updated!");
                } else {
                    System.out.println("Update Fail");
                }
                System.out.print("-------------------------------------" + k + "->");
                k += 100;
                System.out.println(k);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void classify()
    {
        try {
//            ArrayList<OriginEntry> listContent = oed.getAll();
            ArrayList<OriginEntry> listContent = oed.getAllLike();
            int l = listContent.size();
            for (int i = 0; i < l; i++) {
                String text = listContent.get(i).getsContent();
                String cat = ct.classify(text);
                String sent = st.classify(text);
                System.out.println((i + 1) + "--------Category: " + cat + "\tSentiment: " + sent);
                listContent.get(i).setsCategory(cat);
                listContent.get(i).setsSentiment(sent);
            }
            boolean isOK = us.editListOriginEntryUseBatch(listContent);
            if (isOK) {
                System.out.println("Updated!");
            } else {
                System.out.println("Update Fail");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
//        Classify.categoryTrain(Variable.CATEGORY_CLASSIFFIER_DATATRAIN_PATH);
//        Classify.sentimentTrain(Variable.SENTIMENT_CLASSIFFIER_DATATRAIN_PATH);
        Classify.classify();
    }
}
