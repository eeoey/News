package com.ruoyi.system.recommend.recommender;



import com.ruoyi.system.recommend.analyzer.CollaborativeFilteringAnalyzer;
import com.ruoyi.system.recommend.bean.BasicBean;
import com.ruoyi.system.recommend.bean.HabitsBean;
import com.ruoyi.system.recommend.input.ReaderFormat;

import java.io.IOException;
import java.util.*;

/**
 * This is the core in the system,it's a recommend system based on user field.
 * It calculate results with the smiliarity for users' habits.
 * @author wqd
 *
 */
public class UserRecommender {
	
	/**
	 * The method recommend a lists of items for users after calculate the similarity and get the 
	 * top range.According to the most similar users, there is a items lists to recommend a user
	 * serval items. 
	 * @param lists
	 * @param recommendTable
	 * @param user
	 * @param range
	 * @return
	 */
	public List<String> recommend(List<HabitsBean> lists, float[][] recommendTable, BasicBean user, int range) {
		int i = 0;
		HabitsBean bean = null;
		for ( ; i < lists.size(); i++) {
//			System.out.println();
			bean = lists.get(i);
			if(bean.getId() == user.getId()) {
				break;
			}
		}
		range = Math.min(range, lists.size());
		// TODO throws over size exception
		
		//get the top recommend table value of range 
		List<Float> row = new ArrayList<Float>(recommendTable[i].length);
		for (int j = 0; j < recommendTable[i].length; j++) {
			row.add(recommendTable[i][j]);
		}
		Collections.sort(row);
		
		//get the common range of these HabitBean
		int start = row.size() - 1;
		Set<String> sets = new HashSet<String>();
		for (int j = start; j > start - range; j--) {
			// TODO change the method for habitBean,it's a condition
			// the lists id  aren't frequently.
			HabitsBean habits = lists.get(j);
			sets.addAll(habits.getArray());
		}
		
		sets.removeAll(bean.getArray());
		
		return new ArrayList<String>(sets);
	}
	
	
	public static void main(String[] args) throws IOException {
		UserRecommender recommender = new UserRecommender();
		List<HabitsBean> lists = new ReaderFormat().formateLogUser("E:/WorkSpace/Input/ml-100k/u1.base");
		float[][] recommendTable = new CollaborativeFilteringAnalyzer().userSimilarityConsine(lists);
		HabitsBean user = (HabitsBean) lists.get(5);
		recommender.recommend(lists , recommendTable, user, 5);
	}
}
