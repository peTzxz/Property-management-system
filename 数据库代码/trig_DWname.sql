USE [单位房产管理系统]
GO

/****** Object:  Trigger [dbo].[TRIG_DWname]    /
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[TRIG_DWname] ON [dbo].[Worker]
   FOR INSERT
      AS IF( SELECT COUNT(*)
	            FROM INSERTED,Worker
				   WHERE INSERTED.Wname IN 
				                       ( SELECT  Wname 
									          FROM	Worker))=0
ROLLBACK TRANSACTION 
GO

