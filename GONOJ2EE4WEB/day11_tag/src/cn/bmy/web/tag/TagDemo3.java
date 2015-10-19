package cn.bmy.web.tag;

import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//控制标签体重复执行
public class TagDemo3 extends TagSupport
{
	int x = 4;

	public int doStartTag()
	{
		return Tag.EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody()
	{
		x--;
		if(x>0)
			return IterationTag.EVAL_BODY_AGAIN;
		else
			return IterationTag.SKIP_BODY;
	}
}
