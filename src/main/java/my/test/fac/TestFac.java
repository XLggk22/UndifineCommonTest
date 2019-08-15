package my.test.fac;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.bean.BeanUtil;

public class TestFac {

	public static void main(String[] args) {
		DimensionDO dimensionDO = new DimensionDO();
		dimensionDO.setBankCode("0011,0022");
		dimensionDO.setChannelId("BFKJ,JDPay");
		dimensionDO.setTransType("2,4");
		dimensionDO.setMerchantId("SMY,HTBX");
		Map<String, Object> beanToMap = BeanUtil.beanToMap(dimensionDO, false, true);
		//传入的维度不能大于3个
		if(beanToMap.size() >0){
			System.out.println("传入的维度不能大于3个");
		}
		System.out.println(beanToMap.toString());
		System.out.println("-------------------------------");
		Set<Entry<String, Object>> entrySet = beanToMap.entrySet();
		List<JSONObject> conditionList = new ArrayList<>();
		List<JSONObject> conditionListTemp = new ArrayList<>();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			String value = (String)entry.getValue();
			String[] split = value.split(",");
			//迭代属性值，每个属性值拷贝出一个list
			for (int i = 0; i < split.length; i++) {
				//输入值conditionList为空表示第一次进入
				if (conditionList.size() == 0) {
					JSONObject obj = new JSONObject();
					obj.put(key, split[i]);
					conditionListTemp.add(obj);
				}else{
					//从conditionList中copy
					for (JSONObject obj : conditionList) {
						JSONObject copyObj = (JSONObject) obj.clone();
						copyObj.put(key, split[i]);
						conditionListTemp.add(copyObj);
					}
				}
			}
			conditionList.clear();
			conditionList.addAll(conditionListTemp);
			conditionListTemp.clear();
			System.out.println(conditionList.toString());
		}
		System.out.println(conditionList.size());
	}
	
}
