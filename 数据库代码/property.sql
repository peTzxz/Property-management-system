USE [单位房产管理系统]
GO

/****** Object:  Table [dbo].[Property]    Script Date: 2016/6/30 12:59:59 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Property](
	[Hno] [char](8) NOT NULL,
	[WaterBaseValue] [float] NOT NULL,
	[NowWaterValue] [float] NULL,
	[ElectricityBaseValue] [float] NOT NULL,
	[NowElectricityValue] [float] NULL,
	[NuturalGasBaseValue] [float] NOT NULL,
	[NowNuturalValue] [float] NULL,
	[NowYears] [int] NOT NULL,
	[NowMonths] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Hno] ASC,
	[NowYears] ASC,
	[NowMonths] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Property]  WITH CHECK ADD FOREIGN KEY([Hno])
REFERENCES [dbo].[HousingSituation] ([Hno])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Property]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_NowElectricityValue] CHECK  (([NowElectricityValue]>=[ElectricityBaseValue]))
GO

ALTER TABLE [dbo].[Property] CHECK CONSTRAINT [CONSTRAINT_NowElectricityValue]
GO

ALTER TABLE [dbo].[Property]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_NowMonths] CHECK  (([NowMonths]>=(1) AND [NowMonths]<=(12)))
GO

ALTER TABLE [dbo].[Property] CHECK CONSTRAINT [CONSTRAINT_NowMonths]
GO

ALTER TABLE [dbo].[Property]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_NowNuturalValue] CHECK  (([NowNuturalValue]>=[NuturalGasBaseValue]))
GO

ALTER TABLE [dbo].[Property] CHECK CONSTRAINT [CONSTRAINT_NowNuturalValue]
GO

ALTER TABLE [dbo].[Property]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_NowWaterValue] CHECK  (([NowWaterValue]>=[WaterBaseValue]))
GO

ALTER TABLE [dbo].[Property] CHECK CONSTRAINT [CONSTRAINT_NowWaterValue]
GO

ALTER TABLE [dbo].[Property]  WITH CHECK ADD  CONSTRAINT [CONSTRAINT_NowYears] CHECK  (([NowYears]>=(2016)))
GO

ALTER TABLE [dbo].[Property] CHECK CONSTRAINT [CONSTRAINT_NowYears]
GO

