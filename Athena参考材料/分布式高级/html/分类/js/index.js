//δΈζθε
$(function () {
    $(".hd_wrap_left>.dorpdown").mouseover(function () {
        $(this).children(".dd").show();
        $(this).css("background", "#fff");

    }).mouseout(function () {
        $(this).children(".dd").hide();

        $(this).css("background", "#E3E4E5")

    });
    $(".hd_wrap_right>.hd_dj").mouseover(function () {
        $(this).children(".hd_dj_ol").show();
        $(this).css("background", "#fff");
    }).mouseout(function () {
        $(this).children(".hd_dj_ol").hide();
        $(this).css("background", "#E3E4E5");
    });
    $(".hd_wrap_right>.hd_kh").mouseover(function () {
        $(this).children(".hd_kh_ol").show();
        $(this).css("background", "#fff");
    }).mouseout(function () {
        $(this).children(".hd_kh_ol").hide();
        $(this).css("background", "#E3E4E5");
    });
    $(".hd_wrap_right>.hd_daohang").mouseover(function () {
        $(this).children(".hd_dh").show();
        $(this).css("background", "#fff");
    }).mouseout(function () {
        $(this).children(".hd_dh").hide();
        $(this).css("background", "#E3E4E5");
    });
    $(".hd_wrap_right>.hd_jing").mouseover(function () {
        $(this).children(".hd_jing_sj").show()
    }).mouseout(function () {
        $(this).children(".hd_jing_sj").hide()
    });
    $(".nav_top_three>.cw-icon").mouseover(function () {
        $(this).children(".dorpdown-layer").show()
        $(this).css("background", "#fff");
    }).mouseout(function () {
        $(this).children(".dorpdown-layer").hide()
    });

    $(".nav_down_ul_1").mouseover(function () {
        $(this).children(".nav_down_ul_ol").show();
    }).mouseout(function () {
        $(this).children(".nav_down_ul_ol").hide();
    })
    $(".li-1").mouseover(function () {
        $(this).children("#fen").show();
    }).mouseout(function () {
        $(this).children("#fen").hide();
    })
    $(".list_goods>.list_cover>a").mouseover(function () {
        $(this).children(".a_ol").show();
    }).mouseout(function () {
        $(this).children(".a_ol").hide();
    })
    $(".glyphicon-share").mouseover(function () {
        $(this).children(".wang").show();
    }).mouseout(function () {
        $(this).children(".wang").hide();
    })

});


window.onload = function () {
    var mySwiper = new Swiper('.banner1', {
        loop: true,
        // ε¦ζιθ¦ει‘΅ε¨
        pagination: '.swiper-pagination',  //ε°εηΉζΎη€Ί
        paginationType: 'custom',
        paginationCustomRender: function (swiper, current, total) {
            var _html = '';
            for (var i = 1; i <= total; i++) {
                if (current == i) {
                    _html += '<li class="swiper-pagination-custom active llll">' + i + '</li>';
                } else {
                    _html += '<li class="swiper-pagination-custom llll">' + i + '</li>';
                }
            }
            return _html; //θΏεζζηι‘΅η html
        }

    })
    //η»ζ―δΈͺι‘΅η η»ε?θ·³θ½¬ηδΊδ»Ά
    $('.banner1').on('mouseover', 'li', function () {
        var index = this.innerHTML;
        mySwiper.slideTo(index, 500, false); //εζ’ε°η¬¬δΈδΈͺslideοΌιεΊ¦δΈΊ1η§
    })


    var Banner = new Swiper('.banner', {
        loop: true,
        // ε¦ζιθ¦ει‘΅ε¨
        pagination: '.swiper-pagination',  //ε°εηΉζΎη€Ί
        paginationType: 'custom',
        paginationCustomRender: function (swiper, current, total) {
            var _html = '';
            for (var i = 1; i <= total; i++) {
                if (current == i) {
                    _html += '<li class="swiper-pagination-custom active la">' + i + '</li>';
                } else {
                    _html += '<li class="swiper-pagination-custom la">' + i + '</li>';
                }
            }
            return _html; //θΏεζζηι‘΅η html
        }

    })
    //η»ζ―δΈͺι‘΅η η»ε?θ·³θ½¬ηδΊδ»Ά
    $('.banner').on('mouseover', 'li', function () {
        var index = this.innerHTML;
        Banner.slideTo(index, 500, false); //εζ’ε°η¬¬δΈδΈͺslideοΌιεΊ¦δΈΊ1η§
    })


}







