CREATE DATABASE FU_DB
CREATE TABLE Stocks(
	StockID INT PRIMARY KEY,
	StockName NVARCHAR(30),
	[Address] NVARCHAR(45),
	DateAvailable DATE,
	Note NVARCHAR(45)
)
INSERT dbo.Stocks
(
    StockID,
    StockName,
    Address,
    DateAvailable,
    Note
)
VALUES
(   1,
    N'Stock one',
    N'No1 - Wasington',
    GETDATE(),
    N''
    )
INSERT dbo.Stocks
(
    StockID,
    StockName,
    Address,
    DateAvailable,
    Note
)
VALUES
(   2,
    N'Stock two',
    N'372 Cave town',
    GETDATE(),
    N''
    )
INSERT dbo.Stocks
(
    StockID,
    StockName,
    Address,
    DateAvailable,
    Note
)
VALUES
(   3,
    N'Stock three',
    N'Nary angle - 890',
    GETDATE(),
    N'Store dangerous'
    )
INSERT dbo.Stocks
(
    StockID,
    StockName,
    Address,
    DateAvailable,
    Note
)
VALUES
(   4,
    N'Stock four',
    N'Twin tower - 01',
    GETDATE(),
    N''
    )
INSERT dbo.Stocks
(
    StockID,
    StockName,
    Address,
    DateAvailable,
    Note
)
VALUES
(   5,
    N'Stock five',
    N'Victory anniversary',
    GETDATE(),
    N''
    )
