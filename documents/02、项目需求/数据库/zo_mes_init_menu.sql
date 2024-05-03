-- ----------------------------
-- TODO: 需要根据系统功能完善系统菜单相关数据书写
-- ----------------------------
USE `zo_mes`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-04-07 00:29:31', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2022-04-07 00:29:31', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-04-07 00:29:31', '', NULL, '系统工具目录');

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-04-07 00:29:31', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 3, '1', 0, 0, '0', '0', 'admin', '2022-04-07 00:29:31', 'admin', '2022-08-21 23:17:22', '普通角色');
INSERT INTO `sys_role` VALUES (3, '测试员', 'tester', 6, '1', 1, 1, '0', '0', 'admin', '2022-05-04 17:57:40', 'admin', '2022-08-19 09:42:33', NULL);
INSERT INTO `sys_role` VALUES (4, '生产副总', 'visprod', 4, '1', 1, 1, '0', '0', 'admin', '2022-05-10 10:13:06', 'admin', '2022-05-10 16:26:50', NULL);
INSERT INTO `sys_role` VALUES (5, '生产主管', 'proManager', 5, '1', 0, 0, '0', '0', 'admin', '2022-05-10 16:29:13', 'admin', '2023-11-07 22:43:32', NULL);

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);

SET FOREIGN_KEY_CHECKS = 1;
