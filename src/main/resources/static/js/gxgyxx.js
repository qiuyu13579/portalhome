/* by tangyk 西兰花 on 2017/1/22 */

//首页菜单第一个子元素取消间隔竖线
$(function(){   
    $(".h-nav a:first-child").addClass("first");
    $(".list-news li:last-child").css("border-bottom","none");
});


//顶部导航菜单
jQuery(document).ready(function(){
  var qcloud={};
  $('[h_nav]').hover(function(){
    var _nav = $(this).attr('h_nav');
    clearTimeout( qcloud[ _nav + '_timer' ] );
    qcloud[ _nav + '_timer' ] = setTimeout(function(){
    $('[h_nav]').each(function(){
    $(this)[ _nav == $(this).attr('h_nav') ? 'addClass':'removeClass' ]('nav-up-hover');
    });
    $('#'+_nav).stop(true,true).slideDown(200);
    }, 150);
  },function(){
    var _nav = $(this).attr('h_nav');
    clearTimeout( qcloud[ _nav + '_timer' ] );
    qcloud[ _nav + '_timer' ] = setTimeout(function(){
    $('[h_nav]').removeClass('nav-up-hover');
    $('#'+_nav).stop(true,true).slideUp(200);
    }, 150);
  });
});

//搜索框失去和获取焦点border颜色改变
$(function(){   
    $(".search-text").focus(function(){
        $(".search-form").addClass("search-form-focus");
    })
    $(".search-text").blur(function(){
        $(".search-form").removeClass("search-form-focus");
    })
});


//设为首页
function SetHome(obj,url){
    try{
        obj.style.behavior='url(#default#homepage)';
        obj.setHomePage(url);
    }catch(e){
        if(window.netscape){
            try{
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }catch(e){
                alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
            }
        }else{
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+url+"】设置为首页。");
        }
    }
}


//收藏本站
function AddFavorite(title, url) {
    try {
        window.external.addFavorite(url, title);
    }
    catch (e) {
        try {
            window.sidebar.addPanel(title, url, "");
        }
        catch (e) {
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
        }
    }
}


//左边树形菜单
   /*说明 所有的元素以ul li ul li ul li的循环格式嵌套 如果没有下级分类 就用li a结束嵌套*/
$(document).ready(function(){
  $(".treeNav ul li").children("ul").hide();
  $(".treeNav ul li a").append(" <span>></span>");
  $(".treeNav").find("li").not(":has(ul)").children("a").click(function(){
      $(this).get(0).location.href="'"+$(this).attr("href")+"'";
    });
    $(".treeNav").find("li:has(ul)").children("a").click(function(){
      if($(this).next("ul").is(":hidden")){
      $(this).next("ul").slideDown("slow");
      if($(this).parent("li").siblings("li").children("ul").is(":visible")){
      $(this).parent("li").siblings("li").find("ul").slideUp("1000");
    }
    return false;
    }else{
    $(this).next("ul").slideUp("normal");
    //不用toggle()的原因是为了在收缩菜单的时候同时也将该菜单的下级菜单以后的所有元素都隐藏
    return false;
    }
  });
});


//ie9及以下不兼容placeholder
$("document").ready(function(){

    $(function() {
    	if($(".holder")){
    		//$(".holder").placeholder(); 暂时注释
    	}
    	
    });
});



/*//选项卡hover状态
$("document").ready(function(){
    $(".nav-tabs li").each(function(){
        $(this).hover(function(){
        	alert("111111");
            if(!$(this).hasClass('active')){
                $(this).addClass('active').siblings('.active').removeClass('active');
            }else{
                $(this).siblings('.active').removeClass('active');
            }
            var target = $(this).attr('name');
            $("."+target).show();
            $("."+target).siblings('.tab-content .tab-pane').hide();
        });
    });
});*/

/*在线直播：嘉宾介绍上下滚动
$("document").ready(function(){
var speed = 20;
var direction="top";
var tab = document.getElementById("scrollbox");
var tab1 = document.getElementById("boximg");
var tab2 = document.getElementById("fuzhi");
var leftDir = document.getElementById("leftDir");
var rightDir = document.getElementById("rightDir");
tab2.innerHTML = tab1.innerHTML;
function marquee(){
    switch(direction){
        case "top":
            if(tab2.offsetHeight - tab.scrollTop <= 0){
                tab.scrollTop -= tab1.offsetHeight;
            }
            else{
                tab.scrollTop++;
            }
        break;
        case "bottom":
            if(tab.scrollTop <= 0){
                tab.scrollTop += tab2.offsetHeight;
            }
            else{
                tab.scrollTop--;
            }
        break;
    }
}
function changeDirection(dir){
   direction = dir;
}
var timer = setInterval(marquee,speed);
tab.onmouseover = function(){clearInterval(timer);};
tab.onmouseout = function(){timer = setInterval(marquee,speed);};
leftDir.onclick = function(){changeDirection("top");};
rightDir.onclick = function(){changeDirection("bottom");};
});
*/
