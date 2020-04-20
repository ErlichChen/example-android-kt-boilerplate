package com.example.kt.binder.compiler

import com.example.kt.binder.annotations.BindView
import com.example.kt.binder.annotations.OnClick
import java.util.*
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions(AnnotationsProcessor.KAPT_KOTLIN_GENERATED_OPTION_NAME)
class AnnotationsProcessor : AbstractProcessor() {

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }

    lateinit var messager: Messager

    override fun init(env: ProcessingEnvironment?) {
        super.init(env)
        messager = env!!.messager
        messager.printMessage(Diagnostic.Kind.NOTE, "init ---> ")
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        val types: MutableSet<String> = LinkedHashSet()
        types.add(BindView::class.java.canonicalName)
        types.add(OnClick::class.java.canonicalName)
        return types
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        messager.printMessage(Diagnostic.Kind.NOTE, "getSupportedSourceVersion ---> ")
        return SourceVersion.latestSupported()
    }

    override fun process(set: MutableSet<out TypeElement>?, env: RoundEnvironment?): Boolean {
        messager.printMessage(Diagnostic.Kind.NOTE, "process ---> ")
        for (element in env!!.getElementsAnnotatedWith(BindView::class.java)) {
            messager.printMessage(Diagnostic.Kind.NOTE, element.simpleName)
        }
        for (element in env.getElementsAnnotatedWith(OnClick::class.java)) {
            messager.printMessage(Diagnostic.Kind.NOTE, element.simpleName)
        }
        return false
    }

}