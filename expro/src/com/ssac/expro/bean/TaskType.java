package com.ssac.expro.bean;

public class TaskType {
	
	public static final int VERIFY_USER = 00; 						//用户验证
	//提醒
	public static final int GET_REMIND	=	10;							//获取所有的提醒条数
	
	public static final int TODAY_DUE_CUSTOMER = 11;				//今日到访客户
	
	public static final int PROTECT_DUE_CUSTOMER = 12;				//保护到期客户
	
	public static final int PENDING_CHECK_CONTRACT = 13;			//待审核合同
	
	public static final int PENDING_DISTRIBUTE_CUTOMER = 14 ;		//待分配客户
	
//	public static final int PENGDING_DISTRIBUTION_CONTRACT = 14;	//待分配合同
//	public static final int PENDING_CHECK_RETURN_MONEY = 15;		//待审核退款
//	
	public static final int DUE_CONTRACT = 16;						//到期合同
	
	public static final int GET_CLIENT_LIST	= 17;					//所有的客户相关的提醒
	public static final int GET_CONTRACT_LIST = 18;					//所有与 合同相关的提醒
	public static final int GET_REFUND_LSIT	=19;					//所有与 回款相关的提醒
	
	public static final int GET_CLIENT = 20;
	public static final int ALL_CLIENT = 21;						//全部的客户信息
	public static final int MY_CLIENT = 22;							//当前用户对应的客户信息
	public static final int MY_CLIENT_MAP = 221;					//当前用户对应的客户信息30条上限
	public static final int MY_CLIENT_MORE =220;					//更多地客户
	public static final int ADD_CLIENT 		= 23;					//增加客户
	//跟踪记录
	public static final int GET_RECORD 		=	30;					//获取全部的根增记录
	public static final int GET_RECORD_MORE	=	300;				//more
	//记事本
	public static final int STORE_DRAFT_NOTE = 35;					//保存记录草稿 到SD卡
	public static final int DELETE_NOTE	= 36;						//删除草稿
	public static final int UPLOAD_NOTE	= 37;						//上传到服务器
	
	//联系人
	public static final int GET_CONTACTS = 40;						//获取手机的联系人
	public static final int GET_CONTACTS_MORE	=400;				//more
	
	public static final int CLIENT_CONTACTS_LIST	= 42;			//客户信息的里面的联系人列表
	public static final int CONTACTS_LIST_MAP	= 421;				//地图中的关联联系人
	public static final int CLIENT_CONTACTS_LIST_MORE	=420;		//more
	
	//地图
	public static final int GET_DEFALT_MAP = 50;					//默认定位到苏州
	public static final int LOCATE_USER = 51;						//定位到手机的GPS
	public static final int GET_USER_POSITION = 52;					//获取客户的地图位置信息
	
	public static final int CHECK_INFO	= 53;						//销售签到
	
	public static final int DOWN_ERROR = 622;	//更新下载失败
	public static final int GET_UNDATAINFO_ERROR = 223;	//获取服务器信息超时
	public static final int UPDATA_CLIENT = 624;	//通知用户更新系统
	public static final int NO_UPDATE = 625;	//不需要更新
	
	//意向产品
	public static final int GET_PRODUCTS 		=	700;//获取 当前 公司的 所有 产品
	public static final int GET_ORGANIZATIONS	= 701;//获取 当前用户权限内的所有用户组
	
	//分析模块
	public static final int GET_SIGN_CUSTOMER_STATISTICS_TEAMS 	= 800;//获取小组的签约客户的统计数据
	public static final int GET_SIGN_CUSTOMER_STATISTICS_SALES 	= 801;//销售员的签约客户统计
	public static final int GET_SALES_PROCESS_STATISTICS_TEAM 	= 802;//销售过程统计(销售组）
	public static final int GET_SALES_PROCESS_STATISTICS_SALES 	= 803;//销售过程统计(销售员）
	public static final int GET_SALES_PROCESS_SALES_CLIENTS		= 8031;//销售过程的四级页面 （销售的数据）
	public static final int GET_SALES_PROCESS_SALES_CLIENTS_MORE= 8032;//销售过程的四级页面 More（销售的数据）
	public static final int GET_SALES_CONTRACT_STATISTICS 		= 804;//销售合同统计
	public static final int GET_SALES_CONTRACT_STATISTICS_MORE	= 8041;//销售合同统计More
	public static final int GET_ANALYZE							= 805;//获取分析的数据
	public static final int GET_SALES_CONTRACT_STATISTICS_SALES	= 806;//获取个人的 本日/周/月 合同
	public static final int GET_CHASE_INFO						= 8070;//获取到款明细
	public static final int GET_CHASE_INFO_MORE					= 8071;//到款明细 More
	
	//获取员工
	public static final int GET_PEOPLE							= 8072;//获取对应组织下的 员工 
	
	//合同模块
	public static final int GET_CONTRACT						=900;//获取 一级的合同信息
	public static final int GET_CONTRACT_MORE					=901;//获取 一级的合同信息的下一页
	
	//数据字典
	public static final int GET_DICTIONARY						=1000;//获取数据字典集合
	
	//没有更多的数据
	public static final int NO_MORE_DATA						=-100;//没有数据
	
	//3级区域
	public static final int GET_AREA_PROVINCE					=	1010;//获取省份
	public static final int GET_AREA_CITY						=	1011;//获取城市
	public static final int GET_AREA_COUNTRY					=	1012;//获取乡镇
}
