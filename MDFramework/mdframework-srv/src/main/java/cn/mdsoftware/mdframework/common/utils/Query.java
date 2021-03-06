package cn.mdsoftware.mdframework.common.utils;

import com.github.pagehelper.PageHelper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 
	private int offset;
	// 每页条数
	private int limit;

	public Query(Map<String, Object> params) {
		this.putAll(params);
		if (params.get("offset") != null && params.get("limit") != null){
			// 分页参数
			this.offset = Integer.parseInt(params.get("offset").toString());
			this.limit = Integer.parseInt(params.get("limit").toString());
			this.remove("offset");
			this.remove("limit");
			PageHelper.startPage((offset / limit + 1),limit);
		}
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
