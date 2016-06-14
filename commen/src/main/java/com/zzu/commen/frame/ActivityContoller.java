package com.zzu.commen.frame;

import android.app.Activity;

import com.zzu.commen.frame.presenter.BasePresenterActivity;
import com.zzu.commen.utils.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lpp on 2016/6/13.
 *
 * Activity堆栈管理类
 */
public class ActivityContoller {
    private static ActivityContoller instance;

    public static ActivityContoller getInstanse() {
        if (instance == null)
            instance = new ActivityContoller();
        return instance;
    }

    /**
     * 释放单例对象
     */
    public static void release() {
        if (instance.getActivityList() != null) {
            instance.dispose();
        }
        instance = null;
    }

    private List<BasePresenterActivity> activityList;

    private List<BasePresenterActivity> searchFlowList;

    //private Map<String,BasePresenterActivity> mapActivities;

    public List<BasePresenterActivity> getActivityList() {
//		if (this.activityList == null)
//			this.activityList = new ArrayList<BasePresenterActivity>();
        return activityList;
    }

    private ActivityContoller() {

    }

    /**
     * 向Activity管理堆栈中存放Activity
     *
     * @param activity 目标Activity
     */
    public void addActivity(BasePresenterActivity activity) {
        if (this.activityList == null)
            this.activityList = new ArrayList<BasePresenterActivity>();
        activityList.add(activity);
    }

    public void addActivity(boolean isSearch,BasePresenterActivity activity){
        //addActivity(activity);
        if(this.searchFlowList == null)
            this.searchFlowList = new ArrayList<BasePresenterActivity>();
        searchFlowList.add(activity);
    }


    /**
     * 将Activity从堆栈中移除
     *
     * @param activity 目标Acitivity
     */
    public void removeActivity(BasePresenterActivity activity) {
        if (activityList != null) {
            if (activityList.contains(activity)) {
                activityList.remove(activity);
            }
        }
        if(searchFlowList != null) {
            if (searchFlowList.contains(activity)) {
                searchFlowList.remove(activity);
            }
        }
    }

    /**
     * 完全退出
     */
    public void exit() {
        if (activityList != null && !activityList.isEmpty()) {
            try {
                for (BasePresenterActivity ac : activityList) {
                    ac.finish();
                }
            } catch (Exception e) {
                LogUtil.getUtils().e(e.getMessage());
            }
        }
        if (searchFlowList != null && !searchFlowList.isEmpty()) {
            try {
                for (BasePresenterActivity ac : searchFlowList) {
                    ac.finish();
                }
            } catch (Exception e) {
                LogUtil.getUtils().e(e.getMessage());
            }
        }
    }

    public void dispose() {
        activityList = null;
    }

    /**
     * 根据class name获取activity
     * <p/>
     * Acitivity名称
     *
     * @return 获得的对象
     */
    public Activity getActivityByClassName(String activityName) {
        if (activityList == null || activityList.isEmpty()) {
            return null;
        }
        for (Activity ac : activityList) {
            if (ac.getClass().getName().indexOf(activityName) >= 0) {
                return ac;
            }
        }
        return null;
    }

    /**
     * 根据Activity类名获取Activity对象
     *
     * @param cs Activity的class对象
     * @return 获得的对象
     */
    public BasePresenterActivity getActivityByClass(Class<BasePresenterActivity> cs) {
        if (activityList == null || activityList.isEmpty()) {
            return null;
        }
        for (BasePresenterActivity ac : activityList) {
            if (ac.getClass().equals(cs)) {
                return ac;
            }
        }
        return null;
    }

    /**
     * 弹出activity
     *
     * @param activity
     */
    public void popActivity(BasePresenterActivity activity) {
        removeActivity(activity);
        activity.finish();
    }

    /**
     * 弹出activity到
     *
     * @param cs
     */
    public <T extends BasePresenterActivity> void popUntilActivity(Class<T>... cs) {
        if (activityList == null || activityList.isEmpty()) {
            return;
        }
        List<BasePresenterActivity> list = new ArrayList<BasePresenterActivity>();
        for (int i = activityList.size() - 1; i >= 0; i--) {
            BasePresenterActivity ac = activityList.get(i);
            boolean isTop = false;
            for (int j = 0; j < cs.length; j++) {
                if (ac.getClass().equals(cs[j])) {
                    isTop = true;
                    break;
                }
            }
            if (!isTop) {
                list.add(ac);
            } else
                break;
        }
        for (Iterator<BasePresenterActivity> iterator = list.iterator();
             iterator.hasNext(); ) {
            BasePresenterActivity activity = iterator.next();
            popActivity(activity);
        }
    }


    /**
     * 退出所有的activity
     */
    public void popAllActivity() {
        if (activityList == null || activityList.isEmpty()) {
            return;
        }
        try {
            for (BasePresenterActivity ac : activityList) {
                ac.finish();
            }
        } catch (Exception e) {
            LogUtil.getUtils().e(e.getMessage());
        }
    }

    /**
     * 发出好友请求成功之后关闭搜索之前
     */
    public void finishSearchFlowActivity(){
        int length = searchFlowList.size();
        for(int index = length - 1 ; index >= 0; index-- ){
            searchFlowList.get(index).finish();
        }
        searchFlowList.clear();
    }

}

