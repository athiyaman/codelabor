2.0.0
	org.codelabor.file.strategies > org.codelabor.file.anyframe.idgen.strateties�� refectoring
	javadoc ����

2.0.1
	�ٿ�ε����� �ʰ� ���������� ���� �������ϱ� ���� view �߰�
	��ư, ���̺� �߰�

2.0.2
	UploadUtils ���� ��� �ڸ��� ��� ���� (Unix, Windwos Client ����)

2.0.3
	deleteAll(), selectFile() �߰�
	deleteFile(), selectFile() deprecated
	deleteFileByFileId(), deleteFileByMapId() �߰�

2.0.4
	TestCase �߰�
	javadoc ����
	UploadUtils���� ���� ��� ���� ���, ���丮 ����

2.0.5
	order by file_id �߰�
	tika util�� mime type ����

2.0.6
	filesystem ���� �� tika ��� ����

3.0.0
	Spring 3 flavor�� ���� ����
	Spring 2 ��� ��ɿ� ���� @SuppressWarnings("deprecation") �߰�
	fileName > filename ���� ���� ����
	ojdbc dependency scope�� system���� ����

3.0.1
	Spring 2 ��� Controller ����
	log4jdbc �߰�
	findbug ���� ���� ��ġ

3.0.2
	base class ���� ���� ����
	derby �׽�Ʈ �Ϸ�
	
3.1.0
	Anyframe 5.0 ����	
	
	
	
[derby ��� �� �غ� ����]
derby�� ������ �����ϴ� ���
---------------------------------------------------------------------------
C:\Users\bomber>java -jar %DERBY_HOME%\lib\derbyrun.jar ij
Unable to access jarfile C:\Program

C:\Users\bomber>java -jar "%DERBY_HOME%\lib\derbyrun.jar" ij
ij ���� 10.6
ij> connect 'jdbc:derby:testdb;create=true';
ij> exit;

C:\Users\bomber>java -jar "%DERBY_HOME%\lib\derbynet.jar" start
2011-06-29 01:32:07.758 GMT : �⺻ ���� ���� ��å�� ����Ͽ� ���� �����ڰ� ��ġ�˴ϴ�.
2011-06-29 01:32:08.027 GMT : Apache Derby ��Ʈ��ũ ���� - 10.6.2.1 - (999685)��(��) ���۵Ǿ� ��Ʈ 1527���� ������ ����
�� �غ� �Ǿ����ϴ�.
---------------------------------------------------------------------------	