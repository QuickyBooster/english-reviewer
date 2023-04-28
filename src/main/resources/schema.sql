
CREATE TABLE IF NOT EXISTS WORD(
    id SERIAL PRIMARY KEY ,
    wordi nvarchar(25) not null,
    type nvarchar(9),
    meanvi nvarchar(max),
    meanen nvarchar(max),
    spellingen nvarchar(max),
    spellingus nvarchar(max),
    example nvarchar(max),
    urlen nvarchar(max),
    urlus nvarchar(max)
    );
