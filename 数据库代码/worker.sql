USE [单位房产管理系统]
GO

/****** Object:  Table [dbo].[Worker]    Script Date: 2016/6/30 13:00:21 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Worker](
	[Wno] [char](8) NOT NULL,
	[Wname] [char](10) NOT NULL,
	[Wsex] [char](2) NOT NULL,
	[JoinTime] [char](15) NOT NULL,
	[APosition] [char](30) NULL,
	[PTPosition] [char](30) NULL,
	[MaxAPTime] [char](15) NULL,
	[MaxPTPTime] [char](15) NULL,
	[DWname] [char](10) NULL,
	[Fileno] [char](8) NULL,
	[Hno] [char](8) NULL,
	[Dno] [char](8) NULL,
	[HousingHead] [char](2) NULL,
PRIMARY KEY CLUSTERED 
(
	[Wno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Fileno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Worker]  WITH CHECK ADD FOREIGN KEY([Dno])
REFERENCES [dbo].[Department] ([Dno])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Worker]  WITH CHECK ADD FOREIGN KEY([Hno])
REFERENCES [dbo].[HousingSituation] ([Hno])
ON UPDATE CASCADE
ON DELETE SET NULL
GO

ALTER TABLE [dbo].[Worker]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_Wsex] CHECK  (([Wsex]='女' OR [Wsex]='男'))
GO

ALTER TABLE [dbo].[Worker] CHECK CONSTRAINT [CONSTRAINT_Wsex]
GO

