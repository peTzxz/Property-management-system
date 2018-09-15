USE [单位房产管理系统]
GO

/****** Object:  Table [dbo].[HousingSituation]    Script Date: 2016/6/30 12:59:30 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[HousingSituation](
	[Hno] [char](8) NOT NULL,
	[UsingArea] [float] NOT NULL,
	[NowUserID] [char](8) NULL,
	[LastUserID] [char](8) NULL,
	[EarlistUserID] [char](8) NULL,
	[BalconyArea] [float] NOT NULL,
	[BulidingTime] [char](15) NOT NULL,
	[HousingAddress] [char](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[Hno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[HousingAddress] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

