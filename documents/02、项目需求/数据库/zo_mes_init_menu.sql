-- ----------------------------
-- TODO: 需要根据系统功能完善系统菜单相关数据书写
-- ----------------------------
USE `zo_mes`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'system', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'monitor', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'tool', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (4, '系统首页', 0, 4, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (5, '组织架构', 0, 5, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (6, '排班管理', 0, 6, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (7, '设备管理', 0, 7, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (8, '工装夹具管理', 0, 8, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (9, '生产管理', 0, 9, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (10, '质量管理', 0, 10, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (11, '基础数据', 0, 11, 'mes/md', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'build', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (12, '仓储管理', 0, 14, NULL, NULL, NULL, 1, 0, 'M', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (13, '菜单管理', 1, 1, 'menu', 'system/menu/index', NULL, 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (14, '字典管理', 1, 2, 'dict', 'system/dict/index', NULL, 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (15, '参数设置', 1, 3, 'config', 'system/config/index', NULL, 1, 0, 'C', '0', '0', 'system:config:list', 'edit', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (16, '通知公告', 1, 4, 'notice', 'system/notice/index', NULL, 1, 0, 'C', '0', '0', 'system:notice:list', 'message', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (17, '日志管理', 1, 5, 'log', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'log', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (18, '编码规则', 1, 6, 'autocodeRule', 'system/autocode/index', NULL, 1, 0, 'C', '0', '0', 'system:autocode:rule', 'code', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (19, '消息管理', 1, 7, 'message', 'system/message/index', NULL, 1, 0, 'C', '0', '0', 'system:message', 'message', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (20, '车间展示', 10, 1, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (21, '我的代办', 10, 2, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (22, '排班情况', 10, 3, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (23, '库存统计', 10, 4, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (24, '设备信息', 10, 5, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (25, '生产进度', 10, 6, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (26, '质量统计', 10, 7, NULL, NULL, NULL, 1, 0, 'F', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (27, '用户管理', 11, 4, 'user', 'system/user/index', NULL, 1, 0, 'C', '0', '0', 'system:user:list', 'user', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (28, '角色管理', 11, 3, 'role', 'system/role/index', NULL, 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (29, '部门管理', 11, 1, 'dept', 'system/dept/index', NULL, 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (30, '岗位管理', 11, 2, 'post', 'system/post/index', NULL, 1, 0, 'C', '0', '0', 'system:post:list', 'post', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (31, '班组设置', 12, 1, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (32, '排班计划', 12, 2, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (33, '节假日设置', 12, 3, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (34, '排班日历', 12, 4, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (35, '设备类型设置', 13, 1, 'machinerytype', 'mes/dv/machinerytype/index', NULL, 1, 0, 'C', '0', '0', 'mes:dv:machinerytype', 'swagger', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (36, '设备台账', 13, 2, 'machinery', 'mes/dv/machinery/index', NULL, 1, 0, 'C', '0', '0', 'mes:dv:machinery', 'system', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (37, '点检保养项目', 13, 3, 'dvsubject', 'mes/dv/subject/index', NULL, 1, 0, 'C', '0', '0', 'mes:dv:dvsubject', 'cascader', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (38, '点检保养计划', 13, 4, 'checkplan', 'mes/dv/checkplan/index', NULL, 1, 0, 'C', '0', '0', 'mes:dv:checkplan', 'build', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (39, '维修单', 13, 5, 'repair', 'mes/dv/repair/index', NULL, 1, 0, 'C', '0', '0', 'mes:dv:repair', 'system', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (40, '类型设置', 14, 1, 'tooltype', 'mes/tm/tooltype/index', NULL, 1, 0, 'C', '0', '0', 'mes:tm:tooltype', 'tree', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (41, '工装夹具台账', 14, 2, 'tool', 'mes/tm/tool/index', NULL, 1, 0, 'C', '0', '0', 'mes:tm:tool', 'date-range', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (42, '生产工单', 15, 1, 'workorder', 'mes/pro/workorder/index', NULL, 1, 0, 'C', '0', '0', 'mes:pro:workorder', 'log', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (43, '工序设置', 15, 2, 'process', 'mes/pro/process/index', NULL, 1, 0, 'C', '0', '0', 'mes:pro:process', 'druid', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (44, '工艺流程', 15, 3, 'proroute', 'mes/pro/proroute/index', NULL, 1, 0, 'C', '0', '0', 'mes:pro:proroute', 'nested', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (45, '生产排产', 15, 4, 'proschedule', 'mes/pro/schedule/index', NULL, 1, 0, 'C', '0', '0', 'mes:pro:protask', 'build', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (46, '生产报工', 15, 5, 'feedback', 'mes/pro/feedback/index', NULL, 1, 0, 'C', '0', '0', 'mes:pro:feedback', 'chart', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (47, '检测项设置', 16, 2, 'qcindex', 'mes/qc/qcindex/index', NULL, 1, 0, 'C', '0', '0', 'mes:qc:qcindex', 'checkbox', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (48, '检测模板', 16, 3, 'qctemplate', 'mes/qc/qctemplate/index', NULL, 1, 0, 'C', '0', '0', 'mes:qc:qctemplate', 'example', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (49, '常见缺陷', 16, 1, 'qcdefect', 'mes/qc/qcdefect/index', NULL, 1, 0, 'C', '0', '0', 'mes:qc:qcdefect', 'bug', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (50, '来料检验', 16, 5, 'iqc', 'mes/qc/iqc/iqc', NULL, 1, 0, 'C', '0', '0', 'mes:qc:iqc', 'edit', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (51, '过程检验', 16, 6, 'ipqc', 'mes/qc/ipqc/index', NULL, 1, 0, 'C', '0', '0', 'mes:qc:ipqc', 'job', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (52, '待检任务', 16, 4, 'pendinginspect', 'mes/qc/pendinginspect/index', NULL, 1, 0, 'C', '0', '0', 'mes:qc:pending', 'form', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (53, '物料产品管理', 17, 1, 'mditem', 'mes/md/mditem/index', NULL, 1, 0, 'C', '0', '0', 'ms:md:mditem', 'excel', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (54, '物料产品分类', 17, 2, 'itemtype', 'mes/md/itemtype/index', NULL, 1, 0, 'C', '0', '0', 'mes:md:itemtype', 'nested', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (55, '计量单位', 17, 3, 'unitmeasure', 'mes/md/unitmeasure/index', NULL, 1, 0, 'C', '0', '0', 'mes:md:unitmeasure', 'tab', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (56, '客户管理', 17, 4, 'client', 'mes/md/client/index', NULL, 1, 0, 'C', '0', '0', 'mes:md:client', 'people', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (57, '供应商管理', 17, 5, 'vendor', 'mes/md/vendor/index', NULL, 1, 0, 'C', '0', '0', 'mes:md:vendor', 'peoples', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (58, '车间设置', 17, 6, 'workshop', 'mes/md/workshop/index', NULL, 1, 0, 'C', '0', '0', 'mes:md:workshop', 'zip', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (59, '工作站', 17, 7, 'workstation', 'mes/md/workstation/index', NULL, 1, 0, 'C', '0', '0', 'mes:md:workstation', 'job', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (60, '仓库设置', 18, 1, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (61, '库存现有量', 18, 2, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (62, '采购入库', 18, 3, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (63, '采购退货', 18, 4, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (64, '生产领料', 18, 5, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (65, '生产退料', 18, 6, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (66, '产品入库', 18, 7, NULL, NULL, NULL, 1, 0, 'C', '0', '0', NULL, NULL, '', NULL, '', NULL, '');

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-04-07 00:29:31', '', NULL, '超级管理员');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);

SET FOREIGN_KEY_CHECKS = 1;
