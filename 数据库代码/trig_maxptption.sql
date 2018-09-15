USE [单位房产管理系统]
GO

/****** Object:  Trigger [dbo].[TRIG_MaxPTPTime]    ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE TRIGGER [dbo].[TRIG_MaxPTPTime] ON [dbo].[Worker]
 FOR UPDATE
   AS IF( SELECT COUNT(*)
             FROM INSERTED,DELETED 
			    WHERE DELETED.MaxPTPTime<INSERTED.MaxPTPTime)=0
	  ROLLBACK TRANSACTION
GO

