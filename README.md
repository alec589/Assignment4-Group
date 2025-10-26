#Digital University System with Role-Based Access Control

##🚀 项目概览 (Project Overview)

本项目实现了一个数字大学系统 (Digital University System)，该系统支持多用户角色，并集成了安全认证和基于角色的访问控制 (Role-Based Access Control, RBAC)。

核心目标: 整合既有的 Java 软件包，并确保管理员、教师、学生和注册中心（教务人员）四个核心用例的正确执行和安全隔离。

##🌟 关键功能

安全认证: 用户登录与登出管理。

权限限制: 严格的基于角色的访问限制。

课程管理: 课程创建、安排和学生选课管理。

教学支持: 教学大纲（Syllabus）的上传、查看与移除。

成绩处理: 成绩录入、GPA 计算和成绩单生成。

🛠️ 安装与设置 (Installation and Setup)

前置条件 (Prerequisites)

请确保您的系统满足以下要求：

Java JDK: 版本 17 或更高版本。

IDE: 推荐使用 NetBeans IDE 或 IntelliJ IDEA。

操作系统: Windows, macOS, 或 Linux 均可。

设置步骤 (Setup Steps)

下载或克隆本项目仓库。

在 NetBeans 或其他 IDE 中打开项目。

执行 Clean and Build (清理并构建) 项目。

运行 MainJFrame 类以启动应用程序。

🔑 认证与访问控制 (Authentication and Access Control)

系统通过登录界面进行认证。成功登录后，用户会被自动重定向到其角色对应的主仪表板。

角色权限 (Authorization Rules)

角色 (Role)

核心功能 (Key Functionalities)

Administrator (管理员)

创建和管理用户账户、部门和组织；分配用户角色。

Faculty (教师)

查看所教课程；上传/查看/移除教学大纲；管理学生名单；提交最终成绩。

Student (学生)

浏览课程；注册和退课（带学分限制验证）；查看成绩单和 GPA。

Registrar (注册中心/教务)

管理学期课程安排（Master Schedule）和课程目录；处理选/退课请求；追踪学费支付；生成报告。

✅ 已实现的功能 (Features Implemented)

管理员 (Administrator)

创建和管理用户账户。

分配不同的用户角色。

管理部门和组织结构。

教师 (Faculty)

查看被分配的课程。

上传、查看和移除教学大纲文件。

管理和更新教师个人资料。

查看已注册学生名单。

成绩提交流程: 分数 $\ge 60$ 计入学分并参与 GPA 计算；分数 $< 60$ 不计学分。

学生 (Student)

浏览所有课程信息。

注册和退课（包含学分上限验证）。

查看成绩单，包括学期 GPA 和累计 GPA。

注册中心 (Registrar)

管理学期课程设置和时间表。

分配教师和设置课程容量。

处理学生的选课/退课请求。

追踪学费支付记录。

生成财务和注册报告。

💡 使用说明 (Usage Instructions)

启动程序，使用有效的用户账户登录。

系统将根据您的角色自动跳转到相应的仪表板。

使用菜单选项执行您权限范围内的操作。

示例用例:

管理员: 创建新的教师用户，并将其分配给相应的部门。

教师: 为课程上传教学大纲，并提交学生的期末成绩。

学生: 注册一门课程，随后查看更新后的 GPA。

🐞 测试指南 (Testing Guide)

为了确保系统功能和权限控制的正确性，建议执行以下测试：

使用有效和无效的凭据测试登录。

分别以每种角色登录，验证屏幕和功能是否符合权限要求。

尝试访问该角色不允许的功能，确认访问控制机制是否严格生效。

示例测试点:

学生尝试修改课程目录（应被拒绝）。

教师上传教学大纲后，验证其可以被正确查看。

成绩录入后，检查学生的成绩单更新和 GPA 计算是否正确。

🚀 未来增强 (Future Enhancements)

以下是未来版本中可能添加的改进和功能：

将数据存储从内存切换到数据库，以实现数据持久化。

添加邮件或系统通知功能，用于通知用户选课或成绩更新。

开发 Web 端或移动端 UI 以提高系统的可访问性。

为满员的课程添加候补名单和自动注册功能。

👥 团队信息与贡献 (Team Information and Contribution)

本项目由四名团队成员完成，每位成员负责一个特定的用例模块及相关系统功能：

成员姓名 (Name)

NUID

核心职责 (Core Responsibility)

Kailu Chen

002565287

管理员模块编码与集成测试。

Lu Wang

002503062

教师模块编码，教学大纲和评分逻辑。

Zuolin Sun

002522648

学生 UI，选课注册，GPA 计算。

Chunyan Li

002522119

注册中心模块，目录和日程管理。

所有团队成员均参与了调试、文档编写和最终审查工作。
