#ifndef _PROPROCESSCONTENT_DO_
#define _PROPROCESSCONTENT_DO_
#include "../DoInclude.h"

/**
 * 生产工序内容表
 */
class ProProcessContentDO
{
	// 内容说明
	CC_SYNTHESIZE(uint64_t, content, Content);
public:
	ProProcessContentDO() {
		content = "";
	}
};

#endif // !_PROPROCESSCONTENT_DO_