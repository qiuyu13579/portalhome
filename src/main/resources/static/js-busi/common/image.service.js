/**
 * 图片上传服务公共js
 */
$(document).ready(function() {
	var uploadUrl =  WEB_ROOT + "/image/uploadimg"
	initFileInput("input-dim-1", uploadUrl);
});

function initFileInput(ctrlName, uploadUrl) {    
    var control = $('#' + ctrlName); 

    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
        uploadAsync: true,//异步上传
        maxFileCount: 8
        
    }).on('fileuploaded', function(event, data) {
    	var config = data.response.initialPreviewConfig[0];
    	alert("图片上传成功\n"+config.caption+",vfsId:"+config.key);
	});
}

