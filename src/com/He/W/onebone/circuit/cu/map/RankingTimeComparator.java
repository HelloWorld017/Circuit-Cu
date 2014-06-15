package com.He.W.onebone.circuit.cu.map;

import java.util.Comparator;

public class RankingTimeComparator implements Comparator{

	@Override
	public int compare(Object lhs, Object rhs) {
		Object[] lar = (Object[])lhs;
		Object[] rar = (Object[])rhs;
		//I hate *.alz or *.egg and I like *.rar, *.zip, *.tar.gz, *.7z etc......
		int larmin = (Integer)lar[1];
		int larsec = (Integer)lar[2];
		int rarmin = (Integer)rar[1];
		int rarsec = (Integer)rar[2];
		if(larmin > rarmin){
			return 1;
		}else if(larmin < rarmin){
			return -1;
		}else if(larmin == rarmin){
			if(larsec > rarsec){
				return 1;
			}else if(larsec < rarsec){
				return -1;
			}else if(larsec == rarsec){
				return 0;
			}
		}
		return 0;
	}

}
