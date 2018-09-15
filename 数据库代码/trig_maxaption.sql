USE [单位房产管理系统]
GO

/****** Object:  Trigger [dbo].[TRIG_MaxAPTime]     ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[TRIG_MaxAPTime]  ON [dbo].[Worker]
  FOR UPDATE
    AS IF( SELECT COUNT(*)
	           FROM DELETED,INSERTED
			      WHERE DELETED.MaxAPTime <INSERTED.MaxAPTime )=0
 ROLLBACK TRANSACTION

GO

