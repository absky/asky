<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城管理系统首页</title>
<link href="css/left.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
<script type="text/javascript" src="js/dtree.js"></script>
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="12"></td>
		</tr>
	</table>
	<table width="100%" border="0">
		<tr>
			<td>
				<div class="dtree">
					<a href="javascript: d.openAll();">展开所有</a> | <a
						href="javascript: d.closeAll();">关闭所有</a>
					<script type="text/javascript">
						d = new dTree('d');
						d.add('01', -1, '系统菜单树');
						d.add('0101', '01', '会员管理', '', '', 'mainFrame');
						d
								.add(
										'010101',
										'0101',
										'会员管理',
										'listUser/1', 
										'', 'mainFrame');
						d.add('0102', '01', '一级分类管理', '', '', 'mainFrame');
						d
								.add(
										'010201',
										'0102',
										'一级分类管理',
										'listCategory/1',
										'', 'mainFrame');
						d.add('0103', '01', '二级分类管理');
						d
								.add(
										'010301',
										'0103',
										'二级分类管理',
										'listCategorySecond/1',
										'', 'mainFrame');
						d.add('0104', '01', '商品管理');
						d
								.add(
										'010401',
										'0104',
										'商品管理',
										'listProduct/1',
										'', 'mainFrame');
						d.add('0105', '01', '订单管理');
						d
								.add(
										'010501',
										'0105',
										'订单管理',
										'',
										'', 'mainFrame');
						document.write(d);
					</script>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>