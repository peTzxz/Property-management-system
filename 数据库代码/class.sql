USE [单位房产管理系统]
GO

/****** Object:  Table [dbo].[Class]    Script Date: 2016/6/30 12:58:56 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Class](
	[Class] [char](20) NOT NULL,
	[HousingStandard] [char](50) NOT NULL,
	[ControlStandard] [char](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Class] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

