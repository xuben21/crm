<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 服务反馈 -->
<div id="feedback">
  <div>
  <form class="form-inline">

  <div class="form-group">
	<select name="consultType" id="" class="form-control">
		 <option value="">请选择服务类型</option>
        <option value="咨询">咨询</option>
        <option value="投诉">投诉</option>
        <option value="建议">建议</option>
	</select>
  </div>
  <div class="form-group">
	<select name="queryStatus" id="" class="form-control">
		 <option value="">请选择服务状态</option>
        <option value="处理中">处理中</option>
        <option value="已处理">已处理</option>
        <option value="已反馈">已反馈</option>
	</select>
  </div>
  <input class="btn btn-default search" type="button" value="查询">
  <input class="btn btn-default" type="reset" value="重置">
</form>
</div>

<div>
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>序号</th>
		      <th>客户名称</th>
		      <th>概要</th>
		      <th>服务类型</th>
		      <th>处理人</th>
		      <th>状态</th>		
			  <th>操作</th>
		    </tr> 
		  </thead>

		  <tbody>
		    <c:forEach items="${feedbackInfo.list }" var="feedback"> 
		    <tr>
		      <td>${feedback.svrId }</td>
		      <td>${feedback.svrCustName }</td>
		      <td>${feedback.svrRequest }</td>
		      <td>${feedback.svrType }</td>
		      <td>${feedback.svrDispose }</td>
		      <td class="zhuangtai">${feedback.svrStatus }</td>
		      <c:if test="${feedback.svrStatus=='处理中' }">
		      <td>
		      	<i value="${feedback.svrId }" class="layui-icon layui-icon-circle-dot" title=""></i>   
		      </td>
		      </c:if>
		      <c:if test="${feedback.svrStatus=='已反馈' }">
		      <td>
		      	<i value="${feedback.svrId }" class="layui-icon layui-icon-face-smile" title=""></i>   
		      </td>
		      </c:if>
		      <c:if test="${feedback.svrStatus=='已处理'  }">
		      <td>
		      	<i value="${feedback.svrId }" class=" layui-icon layui-icon-edit editUser" title="点击进行服务反馈"></i>   
		      </td>
		      </c:if>
		       <c:if test="${feedback.svrStatus=='未处理' }">
		      <td>
		      	<i value="${feedback.svrId }" class="layui-icon layui-icon-circle-dot" title=""></i>   
		      </td>
		      </c:if>
		    </tr> 
		     </c:forEach>
         </tbody>
    </table>
</div>
<div class="fenye">
	<table class="footTable">
			<tr>
				<td colspan="5">共${feedbackInfo.total } 条记录 每页${feedbackInfo.size } 条 第${feedbackInfo.pageNum } 页 <a
					href="javascript:void(0)" onclick="pageSelect(1)">首页</a>
						<c:choose>	
							<c:when test="${feedbackInfo.hasPreviousPage }">
							<a href="javascript:void(0)" onclick="pageSelect(${feedbackInfo.prePage})">上一页</a>
							</c:when>
							<c:otherwise>
							<font color="#ABA8AB">上一页</font>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${feedbackInfo.hasNextPage }">
							<a href="javascript:void(0)" onclick="pageSelect(${feedbackInfo.nextPage})">下一页</a>
							</c:when>
							<c:otherwise>
							<font color="#ABA8AB">下一页</font>
							</c:otherwise>
						</c:choose>
					 <a href="javascript:void(0)" onclick="pageSelect(${feedbackInfo.lastPage })">尾页</a>
				</td>
			</tr>

		</table>
</div>
<!-- 提示模态框 -->
<div class="modal" id="tishi">
  <div class="modal-dialog"  style="width:350px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">服务正在处理中,无法反馈</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
<!-- 新增模态框 -->
<div class="modal"  id="toAdd">
  <div class="modal-dialog" style="height:400px;overflow:auto;">
    <div class="modal-content">
       <form>
					<div class="modal-body">
						
						<div class="form-group">
							<label>服务反馈结果:</label>
							<input type="text" name="result" class="form-control">
						</div>
						
						<div class="form-group">
							<label>客户满意度:</label>
							<select name="satisfy" id="" class="form-control">
							<option value="一星">请选择客户满意度</option>
					        <option value="一星">一星</option>
					        <option value="二星">二星</option>
					        <option value="三星">三星</option>
					        <option value="四星">四星</option>
					        <option value="五星">五星</option>
					        </select>
						</div>
						<div class="form-group">
							<label>状态:</label>
							<input type="text" name="status" class="form-control" value="已反馈" disabled>
							<!-- <select name="city" id="" class="form-control">
							<option value="">请选择状态</option>
					        <option value="0">处理中</option>
					        <option value="1">已处理</option>
					        <option value="2">未处理</option>
					        </select> -->
						</div>
					</div>
				</form>
				<div class="modal-footer">
				    <button class="btn" style="background:#ccc">取消</button>
					<button class="btn" style="background:#ccc">保存</button>
				</div>
    </div>
  </div>
</div>

</div>
<style>
#feedback{
	width: 1140px;
	overflow: hidden;
}
.pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover, .pagination > .active > span, .pagination > .active > span:focus, .pagination > .active > span:hover {
    background-color: #ccc;
    border-color: #ccc;
}
.pagination > li > a, .pagination > li > span {
    color: black;
}
.fenye{
	margin-left: 400px;
}
	.form-inline{
		margin-top: 15px;
		margin-left: 10px;
		margin-bottom: 20px;
	}
	.search{
		margin-left: 50px;
	}
	#add{
		margin-left: 560px;
	}
	.table th,td{
		text-align: center;
	}
	#tishi{
		margin-top: 100px;
	}
	#toAdd{
		margin-top: 50px;
	}
</style>
<script type="text/javascript">
     var srvId;
	$(function(){
		// 查询
		$('.search').click(function(){
			alert('查询')
		})
		// 点击新增显示模态框
		$('.layui-icon-circle-dot').click(function(){
			var status = $(this).closest('tr').find('.zhuangtai').text();
			// var status = $('.zhuangtai').html();
			console.log(status)
			svrId = $(this).attr("value")
			if(status=='已处理') {
				$('#toAdd').show();
			 
				
			} else if(status=='处理中' || status=='未处理'){
				$('#tishi').show();
			}
			
		})
		// 服务详细信息
		$('.layui-icon-face-smile').click(function(){
			svrId = $(this).attr("value")
			 $('.layui-body').load('service/findServiceDetailById/' + svrId);  
		})
		// 关闭提示模态框
		$('.close').click(function(){
			svrId = null
			$('#tishi').hide();
		})
		$('.btn-primary').click(function(){
			$('#tishi').hide();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			svrId = null
			$('button[type=reset]').trigger('click');
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			
			var result = $("input[name=result]").val()
			var satisfy = $("select[name=satisfy]").val()
			var status = $("input[name=status]").val()
			var data = {
				svrId:svrId,
				svrRequest:result,
				svrSatisfy:satisfy,
				svrStatus:status
			}
			var url = "service/saveOrUpdate";
			$(".layui-body").load(url,data);
				$('#toAdd').hide();
			
				 
		})	
	})
</script>