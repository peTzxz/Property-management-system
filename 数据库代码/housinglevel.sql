USE [单位房产管理系统]
GO

/****** Object:  Table [dbo].[HousingLevel]    Script Date: 2016/6/30 12:59:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[HousingLevel](
	[APosition] [char](30) NOT NULL,
	[PTPosition] [char](30) NOT NULL,
	[Class] [char](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[APosition] ASC,
	[PTPosition] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[HousingLevel]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_Class] FOREIGN KEY([Class])
REFERENCES [dbo].[Class] ([Class])
ON UPDATE CASCADE
ON DELETE SET NULL
GO

ALTER TABLE [dbo].[HousingLevel] CHECK CONSTRAINT [CONSTRAINT_Class]
GO

